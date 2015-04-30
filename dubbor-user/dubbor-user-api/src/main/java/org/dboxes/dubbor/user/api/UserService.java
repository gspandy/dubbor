package org.dboxes.dubbor.user.api;

import org.dboxes.dubbor.common.ServiceResult;
import org.dboxes.dubbor.user.dto.UserDTO;

public interface UserService {

    public ServiceResult<UserDTO> findOne(Long id);

}
