package gnu.io;

/**
 * Created by vssavin on 12.08.2022.
 */
public class LibraryLoader {
    public static void load(String libName) {
        String rxtxLoad = System.getProperty(libName + ".load");
        if (rxtxLoad == null) rxtxLoad = System.getenv(libName + ".load");

        if (rxtxLoad != null) {
            if (Boolean.parseBoolean(rxtxLoad)) {
                try {
                    System.loadLibrary(libName);
                } catch (Throwable throwable) {
                    System.err.println(throwable + " thrown while loading " + libName);
                }
            }
        }
    }
}
