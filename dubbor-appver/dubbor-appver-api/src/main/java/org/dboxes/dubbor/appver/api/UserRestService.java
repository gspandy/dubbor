package org.dboxes.dubbor.appver.api;

import javax.validation.constraints.Min;

public interface UserRestService {

    String getUser(@Min(value = 1L, message = "User ID must be greater than 1") Long id/*, HttpServletRequest request*/);

}
