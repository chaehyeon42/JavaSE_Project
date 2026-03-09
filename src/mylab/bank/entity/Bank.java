package mylab.bank.entity;

import mylab.bank.exception.*;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber = 1000; // AC1000부터 시작

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    // 계좌 생성 및 리스트 추가
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // 계좌 번호 자동 생성을 위한 보조 메서드
    public String generateNextId() {
        return "AC" + (nextAccountNumber++);
    }

    // 계좌 검색
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) return acc;
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    // 모든 계좌 정보 출력
    public void showAllAccounts() {
        System.out.println("== 모든 계좌 목록 ==");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
        System.out.println("================");
    }

    // 계좌 이체
    public void transfer(String fromId, String toId, double amount) throws Exception {
        Account from = findAccount(fromId);
        Account to = findAccount(toId);
        from.withdraw(amount);
        to.deposit(amount);
        System.out.printf("%.1f원이 출금되었습니다. 현재 잔액: %.1f원\n", amount, from.getBalance());
        System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f원\n", amount, to.getBalance());
        System.out.printf("%.1f원이 %s에서 %s로 송금되었습니다.\n", amount, fromId, toId);
    }
}