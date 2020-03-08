package com.rtiwari.sales.currentuser;

import com.rtiwari.sales.model.CurrentUser;

/**
 *
 * @author rtiwari
 */
public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, String userId);
}
