package org.dboxes.dubbor.appver.user.service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import org.dboxes.dubbor.appver.api.UserRestService;
import org.dboxes.dubbor.common.ServiceResult;
import org.dboxes.dubbor.user.api.UserService;
import org.dboxes.dubbor.user.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("users")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class UserRestServiceImpl implements UserRestService {

//    private static final Logger logger = LoggerFactory.getLogger(UserRestServiceImpl.class);

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("{id : \\d+}")
    public String getUser(@PathParam("id") Long id/*, @Context HttpServletRequest request*/) {
        // test context injection
        //if (RpcContext.getContext().getRequest(HttpServletRequest.class) != null) {
        //    System.out.println("Client IP address from RpcContext: " + RpcContext.getContext().getRequest(HttpServletRequest.class).getRemoteAddr());
        //}
        //if (RpcContext.getContext().getResponse(HttpServletResponse.class) != null) {
        //    System.out.println("Response object from RpcContext: " + RpcContext.getContext().getResponse(HttpServletResponse.class));
        //}
        ServiceResult<UserDTO> user = userService.findOne(id);
        if (user == null) {
            return null;
        }
        if (user.getResult() == null) {
            return null;
        }
        //return "Hello REST";
        return user.getResult().toString();
    }

}
