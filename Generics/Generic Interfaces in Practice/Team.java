import java.util.List;

public interface Team<L extends Employee & TeamLeader, M extends Employee> {

    L getLeader();

    void setLeader(L leader);

    List<M> getMembers();

    void setMembers(List<M> members);
}