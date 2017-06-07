package DAO;

public class ExceptionDao extends RuntimeException {
    public ExceptionDao(Throwable cause ) {
        super( cause );
    }
}

