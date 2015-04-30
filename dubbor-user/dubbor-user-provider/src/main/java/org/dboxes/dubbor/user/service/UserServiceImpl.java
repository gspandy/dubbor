package org.dboxes.dubbor.user.service;


import org.dboxes.dubbor.common.ServiceResult;
import org.dboxes.dubbor.user.api.UserService;
import org.dboxes.dubbor.user.domain.User;
import org.dboxes.dubbor.user.dto.UserDTO;
import org.dboxes.dubbor.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServiceResult<UserDTO> findOne(Long id) {
        ServiceResult<UserDTO> result = new ServiceResult<UserDTO>();

        User user = userMapper.findOne(id);
        if (user != null){
            UserDTO dto= new UserDTO();
            dto.setId(user.getId());
            dto.setLoginName(user.getLoginName());
            dto.setNickName(user.getNickName());
            dto.setPhone(user.getPhone());
            dto.setEmail(user.getEmail());
            result.setResult(dto);
        }

        return result;
    }
}
