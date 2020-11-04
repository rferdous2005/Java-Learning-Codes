public class Executive extends Employee implements TeamLeader {
    @Override
    public void callForMeeting() {
        System.out.println("Sending notifications to team members for meeting");
    }
}
