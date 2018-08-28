package utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ICodeGeneratorImpl implements ICodeGenerator {
    private Set<Integer> codes;
    private static ICodeGenerator instance;
    private Random random;

    public static ICodeGenerator getInstance() {
        if (instance == null) {
            instance = new ICodeGeneratorImpl();
        }
        return instance;
    }

    private ICodeGeneratorImpl() {
        this.codes = new HashSet<Integer>();
        this.random = new Random();
    }

    public synchronized int generateCode() {
        int randedCode;
        while (codes.contains(randedCode = Math.abs(random.nextInt())) == true) {}
        return randedCode;
    }
}
