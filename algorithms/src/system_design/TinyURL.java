package system_design;

public class TinyURL {

	// http://blog.gainlo.co/index.php/2016/03/08/system-design-interview-question-create-tinyurl-system/
	// https://leetcode.com/problems/design-tinyurl/discuss/100258/
	
	// URL encode and decode - https://leetcode.com/problems/encode-and-decode-tinyurl/solution/
	/**
	 * A random string is not a hash. The fundamental property of hashes is that
	 * they are functions from a domain (say strings) to a smaller domain (say
	 * strings of 5 characters). The same input produces always the same output.
	 * Neither hashes nor random strings of 7 characters would work in practice. You
	 * calculated how many URLs you can store, but that assumes you can efficiently
	 * use all that space. Once you have a few urls stored in your system, you will
	 * have clashes. Avoiding those clashes is non trivial in a globally distributed
	 * system. Even worse, random strings will will hit that limit much earlier if
	 * the system is popular since every requests generates a new key. Conversely,
	 * with actual hashes, the likelihood of clashes depends on the amount of urls
	 * you store. Since you have chosen a fairly long identifier, you ‘d be “more or
	 * less” safe until you store about 100.000.000 URLs, but that goes against the
	 * URL being “tiny”. You could store the 644000000 urls using 5 character
	 * identifiers, so your identifiers are currently too big.
	 * 
	 * When you suggest using a “better function” pointing out to actual hashes.
	 * Both functions that you suggest are bad examples. CRC is designed for cheap
	 * error detection, it’s distribution is less than ideal and is easy to attack
	 * (an attacker could very easily generate many different urls that hash to the
	 * same crc). SHA-1 is better, but has also know attacks.
	 * 
	 * I doubt there is a cost penalty for the database depending on which type of
	 * ID you use. The cost of random IDs is that you need to check for clashes
	 * which requires a transaction, which is not really possible in a globally
	 * distributed system.
	 * 
	 * I got confused when you introduced the idea of using GUIDs. GUIDs won’t work,
	 * they are simply too large (to guarantee uniqueness). But then you move to
	 * incremental ids, I assume that you refer to a counter that increments per
	 * time you write an entry. While that could work, there is much more to that.
	 * Generating a unique sequence of ids in a distributed system is not trivial
	 * either, you’ll need to find your ways around that. However, once you do that,
	 * why are you adding an extra hash to the ID? It is already unique.
	 * 
	 * You don’t only need distribution due to scalability issues (which I doubt
	 * would be much of a problem here) but due to both availability and latency. If
	 * the system is global, you don’t want people in Australia connecting to some
	 * datacenter in Ireland, plus you need to cope with network and server
	 * failures. Distributing the solution _is_ the meat of this problem, if you
	 * could solve it with only one computer is pretty trivial.
	 */
	
	// things to learn
	
	// Sharding
	// calculation of size
}
