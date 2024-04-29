package practice2.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototype2 {

    @Test
    void singletonBeanUsePrototypeBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class, SingletonBean.class);

        SingletonBean singletonBean = ac.getBean(SingletonBean.class);
        int count1 = singletonBean.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        int count2 = singletonBean1.logic();
        Assertions.assertThat(count2).isEqualTo(1);

        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean {

        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }

    @Scope("singleton")
    static class SingletonBean {

        private ObjectProvider<PrototypeBean> prototypeBeanProvider;

        public SingletonBean(ObjectProvider<PrototypeBean> prototypeBeanProvider) {
            this.prototypeBeanProvider = prototypeBeanProvider;
        }

        public int logic() {
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            prototypeBean.addCount();

            return prototypeBean.getCount();
        }
    }
}
