package net.media.training.live.lsp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 12, 2011
 * Time: 1:05:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class MembershipChecker {

    public static boolean check(List elements, Set uniqueElements) {
        for (Object element : elements) {
            if (!uniqueElements.isMember(element))
                return false;
        }
        return true;
    }

    public static PersistentObject<String> getObject(String data){
         return new PersistentObject<>(data);
    }
    public static void main(String[] args) {
        List elements = new ArrayList() {{
            add(getObject("a"));
            add(getObject("b"));
            add(getObject("c"));
        }};

        Set<PersistentObject<String>> uniqueElements = new PersistentSet<>();
        uniqueElements.add(getObject("c"));
        uniqueElements.add(getObject("b"));
        uniqueElements.add(getObject("a"));

        System.out.println("Check1: " + MembershipChecker.check(elements, uniqueElements));

        List anotherElements = new ArrayList() {{
            add(getObject("a"));
            add(getObject("c"));
            add(getObject("d"));
        }};
        System.out.println("Check2: " + MembershipChecker.check(anotherElements, uniqueElements));
    }
}
