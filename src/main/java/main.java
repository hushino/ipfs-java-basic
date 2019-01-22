import io.ipfs.api.IPFS;
import io.ipfs.api.KeyInfo;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;

import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
        ipfs.refs.local();
        //NamedStreamable.FileWrapper file = new NamedStreamable.FileWrapper(new File("C:/Users/hushino/IdeaProjects/magic/src/main/resources/hello.txt"));
        NamedStreamable.ByteArrayWrapper file = new NamedStreamable.ByteArrayWrapper("C:/Users/hushino/IdeaProjects/magic/src/main/resources/carp", "G'day world! IPFS rocks!".getBytes());
        MerkleNode addResult = ipfs.add(file).get(0);
        Multihash pointer = addResult.hash;
        System.out.println(pointer);
    }
    /* in the other side
    IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
    Multihash filePointer = Multihash.fromBase58("Qmc7H7uVuDWPKLQDvynMegKP7L5FpEJD83requxXucKxJn");
        try {
        List<Multihash> pinned = ipfs.pin.add(filePointer);
        List<KeyInfo> existing = ipfs.key.list();
        byte[] fileContents = ipfs.cat(filePointer);
        String s = new String(fileContents);
        System.out.println(s+' '+existing);
    } catch (IOException e) {
        e.printStackTrace();
    }*/
}