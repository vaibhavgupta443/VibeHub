package com.socialnetwork.testUtils;

import com.socialnetwork.domain.entities.Relationship;
import com.socialnetwork.domain.entities.User;
import com.socialnetwork.domain.models.serviceModels.RelationshipServiceModel;
import com.socialnetwork.domain.models.viewModels.relationship.FriendsAllViewModel;
import com.socialnetwork.domain.models.viewModels.relationship.FriendsCandidatesViewModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RelationshipsUtils {
    public static Relationship createRelationship(User userOne, User userTwo, int status, User actionUser) {
        LocalDateTime time = LocalDateTime.now();

        return new Relationship() {{
            setId("1");
            setUserOne(userOne);
            setUserTwo(userTwo);
            setStatus(status);
            setActionUser(actionUser);
            setTime(time);
        }};
    }

    public static List<Relationship> getRelationshipList(int count, User userOne, User userTwo, int status, User actionUser) {
        LocalDateTime time = LocalDateTime.now();

        return IntStream.range(0, count)
                .mapToObj(index -> new Relationship() {{
                    setId(String.valueOf(index + 1));
                    setUserOne(userOne);
                    setUserTwo(userTwo);
                    setStatus(status);
                    setActionUser(actionUser);
                    setTime(time);
                }})
                .collect(Collectors.toList());
    }

    public static RelationshipServiceModel getRelationshipServiceModel(User userOne, User userTwo, int status, User actionUser) {
        LocalDateTime time = LocalDateTime.now();

        return new RelationshipServiceModel() {{
            setId(String.valueOf(1));
            setUserOne(userOne);
            setUserTwo(userTwo);
            setStatus(status);
            setActionUser(actionUser);
            setTime(time);
        }};
    }

    public static List<FriendsCandidatesViewModel> getFriendsCandidatesViewModel(int count) {
        return IntStream.range(0, count)
                .mapToObj(index -> new FriendsCandidatesViewModel() {{
                    setId(String.valueOf(index + 1));
                    setFirstName("Pesho " + index);
                    setLastName("Peshov " + index);
                    setUsername("pesho " + index);
                    setProfilePicUrl("profilePic " + index);
                    setBackgroundImageUrl("backgroundPic " + index);
                    setStarterOfAction(false);
                    setStatus(2);
                }})
                .collect(Collectors.toList());
    }

    public static List<FriendsAllViewModel> getFriendsAllViewModels(int count) {
        return IntStream.range(0, count)
                .mapToObj(index -> new FriendsAllViewModel() {{
                    setId(String.valueOf(index + 1));
                    setFirstName("Pesho " + index);
                    setLastName("Peshov " + index);
                    setUsername("pesho " + index);
                    setProfilePicUrl("profilePic " + index);
                    setBackgroundImageUrl("backgroundPic " + index);
                }})
                .collect(Collectors.toList());
    }
}
