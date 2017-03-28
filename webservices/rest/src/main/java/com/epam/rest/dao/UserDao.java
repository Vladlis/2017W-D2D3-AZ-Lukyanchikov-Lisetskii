package com.epam.rest.dao;

import com.epam.rest.domain.User;

public interface UserDao {
    /**
     * Add new user.
     * @param user the user to add.
     * @return id of the added user.
     */
    int add(User user);

    /**
     * Update user.
     * @param user the user to update.
     * @return updated user.
     */
    User update(User user);

    /**
     * Delete user.
     * @param id user id.
     * @return deleted user.
     */
    User delete(int id);

    /**
     * Get user by id.
     * @param id user id.
     * @return user, if found and null otherwise.
     */
    User get(int id);
}
