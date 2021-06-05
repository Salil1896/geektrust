package com.example.models;

public enum CommandType {
    LOAN {
        public <T> T accept(CommandTypeVisitor<T> visitor) {
            return visitor.visitLoan();
        }
    },
    PAYMENT {
        public <T> T accept(CommandTypeVisitor<T> visitor) {
            return visitor.visitPayment();
        }
    },
    BALANCE {
        public <T> T accept(CommandTypeVisitor<T> visitor) {
            return visitor.visitBalance();
        }
    };

    public abstract <V> V accept(CommandTypeVisitor<V> visitor);

    public interface CommandTypeVisitor<T> {
        default T visitLoan() {
            return null;
        }

        default T visitPayment() {
            return null;
        }

        default T visitBalance() {
            return null;
        }
    }
}