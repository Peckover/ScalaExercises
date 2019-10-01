package HashMapsAnagrams

import Day6.HashMapAnagrams
import resources.BaseTestingClass

class HashMapsAnagramsTest extends BaseTestingClass{
  var hashMapsAnagrams: HashMapAnagrams = _

  before {
    hashMapsAnagrams = new HashMapAnagrams
  }

  "A user" should " be able to instantiate a new hashMapAnagrams" in {
    assert(true)
  }

  "The method readFromFile" should " be able to read a line of words from a file" in {
  assert(HashMapsAnagrams.readFromFile(wordsList) == "race military bashful snatch offer")
  }

}
