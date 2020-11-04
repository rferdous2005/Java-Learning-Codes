
public class Main {
    public static void main(String[] args) {

        Account account = new DPSAccount();

        account.describe();
        System.out.println(account.getBankName());

        Debit debitAcc = new Debit() {
            @Override
            public void describe() {
                System.out.println(this.getType());
            }
        };
    }
}
