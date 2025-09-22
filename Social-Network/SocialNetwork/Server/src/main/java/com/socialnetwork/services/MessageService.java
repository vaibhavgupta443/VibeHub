package com.socialnetwork.services;

import com.socialnetwork.domain.models.bindingModels.message.MessageCreateBindingModel;
import com.socialnetwork.domain.models.serviceModels.MessageServiceModel;
import com.socialnetwork.domain.models.viewModels.message.MessageFriendsViewModel;

import java.util.List;

public interface MessageService {

    MessageServiceModel createMessage(MessageCreateBindingModel messageCreateBindingModel, String loggedInUsername) throws Exception;

    List<MessageServiceModel> getAllMessages(String loggedInUsername, String chatUserId);

    List<MessageFriendsViewModel> getAllFriendMessages(String loggedInUsername);
}
