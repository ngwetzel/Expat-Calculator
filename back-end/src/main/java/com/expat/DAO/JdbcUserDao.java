package com.expat.DAO;

import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcUserDao implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findIdByUsername(String username) {
        return jdbcTemplate.queryForObject("select user_id from users where username = ?", int.class, username);
    }

    @Override
    public boolean findIfUsernameIsTeacher(String username) {
        return jdbcTemplate.queryForObject("select is_teacher from users where username = ?", boolean.class, username);
    }

	@Override
	public User getUserById(Long userId) {
		String sql = "SELECT * FROM users WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		if(results.next()) {
			return mapRowToUser(results);
		} else {
			throw new RuntimeException("userId "+userId+" was not found.");
		}
	}

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }

        return users;
    }

    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {
        for (User user : this.findAll()) {
            if( user.getUsername().toLowerCase().equals(username.toLowerCase())) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User " + username + " was not found.");
    }

    @Override
    public boolean create(String username, String firstName, String lastName, boolean isTeacher, String password, String role) {
        boolean userCreated = false;

        // create user
        String insertUser = "insert into users (username, password_hash, role, industry) values(?,?,?,?,?,?)";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        String ssRole = "ROLE_" + role.toUpperCase();

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String id_column = "user_id";
        userCreated = jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(insertUser, new String[]{id_column});
                    ps.setString(1, username);
                    ps.setString(2, password_hash);
                    ps.setString(3, ssRole);
                    ps.setString(4, ssIndustry);
                    return ps;
                }
                , keyHolder) == 1;
        int newUserId = (int) keyHolder.getKeys().get(id_column);
        String sql2 = "INSERT INTO teachers (user_id, first_name, last_name) VALUES (?, ?, ?);";
        if (!isTeacher) {
            String sql = "INSERT INTO students (user_id, first_name, last_name) VALUES (?, ?, ?);";
            jdbcTemplate.update(sql, newUserId, ssFirstName, ssLastName);
        } else
            jdbcTemplate.update(sql2, newUserId, ssFirstName, ssLastName);

        return userCreated;
    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(rs.getString("role"));
        user.setIndustry(rs.getString("industry"));
        user.setActivated(true);
        return user;
    }
}
