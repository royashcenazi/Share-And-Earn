package utils.numberGenerators;

import dataBase.MongoConstants;
import dataBase.MongoInteractor;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CodeGeneratorImplRobust implements IRobustNumberGenerator {
    private Set<Integer> numbers;
    private static IRobustNumberGenerator instance;
    private Random random;
    private String uniqueKey;

    public static IRobustNumberGenerator getInstance() {
        if (instance == null) {
            instance = getInstanceFromDb();
        }
        return instance;
    }

    private static IRobustNumberGenerator getInstanceFromDb() {
        instance = MongoInteractor.getInstance().getCodeGenerator();
        if (instance == null)
            instance = new CodeGeneratorImplRobust();
        return instance;
    }

    public CodeGeneratorImplRobust() {
        this.numbers = new HashSet<Integer>();
        this.random = new Random();
        this.uniqueKey = MongoConstants.UniqueCollectionKey;
    }

    @Override
    public synchronized int generateNumber() {
        int randedCode;
        while (numbers.contains(randedCode = Math.abs(random.nextInt())) == true) {}
        numbers.add(randedCode);
        Thread thread = new Thread(()->MongoInteractor.getInstance().saveCodeGeneratorToDb(this));
        thread.start();
        return randedCode;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }


    public Set<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }

}
