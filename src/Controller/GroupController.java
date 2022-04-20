package Controller;

import Model.Group;
import Sevices.GroupRepo;

public class GroupController {
    private GroupRepo groupRepo;

    public GroupController() {
        groupRepo = new GroupRepo();
    }

    public int create(Group group) {
        return groupRepo.create(group);
    }
}
