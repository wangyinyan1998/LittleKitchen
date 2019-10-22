package com.example.littlekitchen.dao;

import com.example.littlekitchen.entities.FollowUser;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;
@Repository
public interface FollowMapper {
    @NotNull
    int getFollowNumber(Integer userId);
    @NotNull
    List<FollowUser>  getFollowUsers(Integer userId);
    @NotNull
    int addFollow(Integer userId1,Integer userId2);
    @NotNull
    int deleteFollow(Integer userId1,Integer userId2);
    @NotNull
    int isFollowed(Integer userId1,Integer userId2);
}