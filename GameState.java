public class GameState {
    private Account account;
    private Employees employees;
    private List<Stock> portfolio;
    private int currentQuarter;

    public GameState(Account account, Employees employees, List<Stock> portfolio) {
        this.account = account;
        this.employees = employees;
        this.portfolio = portfolio;
        this.currentQuarter = 1;
    }

    public Account getAccount() { return account; }
    public Employees getEmployees() { return employees; }
    public List<Stock> getPortfolio() { return portfolio; }
    public int getCurrentQuarter() { return currentQuarter; }

    public void nextQuarter() {
        currentQuarter++;
    }

    public boolean isGameOver() {
        return currentQuarter > 4 || account.getBalance() <= 0;
    }
}

