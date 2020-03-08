package com.rtiwari.sales.currentuser;

import com.rtiwari.sales.model.CurrentUser;
import com.rtiwari.sales.model.Role;
import org.springframework.stereotype.Service;

/**
 *
 * @author rtiwari
 */
@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    @Override
    public boolean canAccessUser(CurrentUser currentUser, String userId) {
        return currentUser != null
                && (currentUser.getRole().equals(Role.ADMIN.name()) || currentUser.getId().equals(userId));
    }

}
