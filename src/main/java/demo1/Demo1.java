package demo1;

import javassist.*;

/**
 * Created by 1001265 on 16. 3. 22..
 */
public class Demo1 {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("demo1.Adele");
        CtMethod m = cc.getDeclaredMethod("sing");

        m.insertBefore("{ System.out.println(\"Hi, everybody!. \\n i'll sing the song. \\n this song is about nostalgia :\"); }");
        m.insertAfter("{ System.out.println(\"Crowds : Ah~~~ \"); }");

        Class c = cc.toClass();
        Adele h = (Adele)c.newInstance();
        h.sing();
    }
}
