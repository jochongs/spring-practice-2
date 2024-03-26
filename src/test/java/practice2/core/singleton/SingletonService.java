package practice2.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    // 생성자를 private으로 만들면 인스턴스 생성 방어
    private SingletonService() {}

    public static SingletonService getInstance() {
        return instance;
    }
}
