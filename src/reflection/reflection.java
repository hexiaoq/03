package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class reflection {
    public static void main(String[] args) throws Exception{
        Class cus=Class.forName("reflection.customer");//每个类在加载时，都会生成Class类的一个对象，Class类的一个对象cus即相当于customer类
        customer clazz=(customer)cus.newInstance();//clazz相当于cus类的一个对象，这里的cus.newInstance()即相当于用空构造器初始化一个cus对象

        Constructor constructor=cus.getDeclaredConstructor(null);
        customer clazz2=(customer)constructor.newInstance();//获得无参构造器，并利用构造器new对象

        Method method=cus.getDeclaredMethod("setName", String.class);
        method.setAccessible(true);//使得私有方法可以访问
       method.invoke(clazz,"何小强");
        Method m=cus.getDeclaredMethod("getName");

        customer clazz1=(customer)cus.newInstance();
        Field f=cus.getDeclaredField("name");
        f.setAccessible(true);//使得私有属性可访问
        f.set(clazz1,"何小强");

        System.out.println(m.invoke(clazz));
        System.out.println(clazz1.getName());
        System.out.println(cus.hashCode());
        System.out.println(clazz);
    }
}
