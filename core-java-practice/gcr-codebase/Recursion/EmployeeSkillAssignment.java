import java.util.ArrayList;
import java.util.List;

class EmployeeSkillAssignment {

    static void findTeams(int[] skills, int target, int index, List<Integer> current) {
        if (target == 0) {
            System.out.println(current);
            return;
        }
        if (index == skills.length || target < 0) {
            return;
        }

  
        current.add(skills[index]);
        findTeams(skills, target - skills[index], index + 1, current);
        current.remove(current.size() - 1);

      
        findTeams(skills, target, index + 1, current);
    }

    public static void main(String[] args) {
        int[] skills = {2, 3, 5, 7};
        int target = 10;

        findTeams(skills, target, 0, new ArrayList<>());
    }
}
