public class DPSAccount extends Account {

    @Override
    public String getType() {
        return "DPS";
    }

    @Override
    public void describe() {
        System.out.println(this.getType());
    }
}
