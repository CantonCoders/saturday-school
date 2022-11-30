using NUnit.Framework;
using System.Security;
using System.Text;

using static StringHomework.Unique;

namespace StringHomeworkTest
{
    public class UniqueTest
    {

        [Test]
        public void EmptyStringIsUnique()
        {
            Assert.IsTrue(isUnique(""));
        }

        [Test]
        public void SingleCharacterIsUnique()
        {
            Assert.IsTrue(isUnique("A"));
        }

        [Test]
        [Ignore("Implement this feature")]
        public void DublicateCharactersAreNotUnique()
        {
            Assert.IsFalse(isUnique("AA"));
        }

        [Test]
        [Ignore("Implement this feature")]
        public void uniqueIsCaseSensitive()
        {
            Assert.IsTrue(isUnique("Aa"));
        }

        [Test]
        [Ignore("Implement this feature")]
        public void LargeStringIsUnique()
        {
            var str = new StringBuilder();
            for (var i = 0; i < 128; i++)
            {
                str.Append((char) i);
            }
            Assert.IsTrue(isUnique(str.ToString()));
        }

        [Test]
        [Ignore("Implement this feature")]
        public void LargeStringNotUnique()
        {
            var str = new StringBuilder();
            for (var i = 0; i < 128; i++)
            {
                str.Append((char)i);
            }
            str.Append("a");
            Assert.IsFalse(isUnique(str.ToString()));
        }
    }
}