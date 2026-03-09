package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // 1. 계좌 생성 테스트
        System.out.println("== 계좌 생성 ==");
        SavingsAccount sa1 = new SavingsAccount(bank.generateNextId(), "홍길동", 10000.0, 3.0);
        CheckingAccount ca1 = new CheckingAccount(bank.generateNextId(), "김철수", 20000.0, 5000.0);
        SavingsAccount sa2 = new SavingsAccount(bank.generateNextId(), "이영희", 30000.0, 2.0);
        
        bank.addAccount(sa1);
        bank.addAccount(ca1);
        bank.addAccount(sa2);

        System.out.println("Saving(저축) 계좌가 생성되었습니다: " + sa1);
        System.out.println("체킹 계좌가 생성되었습니다: " + ca1);
        System.out.println("저축 계좌가 생성되었습니다: " + sa2);
        System.out.println();

        // 2. 모든 계좌 목록 출력
        bank.showAllAccounts();
        System.out.println();

        // 3. 입금/출금 테스트
        System.out.println("== 입금/출금 테스트 ==");
        sa1.deposit(5000.0);
        System.out.printf("5000.0원이 입금되었습니다. 현재 잔액: %.1f원\n", sa1.getBalance());
        try {
            sa1.withdraw(3000.0);
            System.out.printf("3000.0원이 출금되었습니다. 현재 잔액: %.1f원\n", sa1.getBalance());
        } catch (Exception e) { System.out.println(e.getMessage()); }
        System.out.println();

        // 4. 이자 적용 테스트
        System.out.println("== 이자 적용 테스트 ==");
        double interest = sa1.getBalance() * 0.03; // 15000 * 0.03 = 450
        sa1.deposit(interest);
        System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f원\n", interest, sa1.getBalance());
        System.out.printf("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원\n", interest, sa1.getBalance());
        System.out.println();

        // 5. 계좌 이체 테스트
        System.out.println("== 계좌 이체 테스트 ==");
        try {
            bank.transfer("AC1002", "AC1001", 5000.0);
        } catch (Exception e) { System.out.println(e.getMessage()); }
        System.out.println();

        // 6. 모든 계좌 목록 출력 (최종)
        bank.showAllAccounts();

        // 7. 예외 처리 테스트
        try {
            // 한도 초과 예외
            ca1.withdraw(6000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            // 잔액 부족 예외 (한도 내에서 잔액보다 큰 금액)
            ca1.withdraw(5000.0); 
            ca1.withdraw(5000.0);
            ca1.withdraw(5000.0);
            ca1.withdraw(5000.0); // 여기서 잔액 부족 발생 가능
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            // 존재하지 않는 계좌 예외
            bank.findAccount("AC9999");
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}