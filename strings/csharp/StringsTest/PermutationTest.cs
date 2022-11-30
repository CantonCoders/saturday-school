using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;
using static StringHomework.Permutation;

namespace StringHomeworkTest
{
    internal class PermutationTest
    {
        [Test]
        public void EqualStringsArePermutations()
        {
            Assert.IsTrue(IsPermutation("dog", "dog"));
        }

        [Test]
        [Ignore("Implement this feature")]
        public void PermutationIsCaseSensitive()
        {
            Assert.IsFalse(IsPermutation("dog", "Dog"));
        }

        [Test]
        [Ignore("Implement this feature")]
        public void PermutationsAllowSpaces()
        {
            Assert.IsTrue(IsPermutation("my dog", "my dog"));
        }

        [Test]
        [Ignore("Implement this feature")]
        public void PermutationsEqualInLength()
        {
            Assert.IsFalse(IsPermutation("game", "games"));
            Assert.IsFalse(IsPermutation("games", "game"));
        }

        [Test]
        [Ignore("Implement this feature")]
        public void SameSizedStringsAreNotPermutations()
        {
            Assert.IsFalse(IsPermutation("mace", "mage"));
            Assert.IsFalse(IsPermutation("mage", "mace"));
        }

        [Test]
        [Ignore("Implement this feature")]
        public void PermutationOfUnequalStrings()
        {
            Assert.IsTrue(IsPermutation("game", "mage"));
            Assert.IsTrue(IsPermutation("mage", "game"));
        }

        [Test]
        [Ignore("Implement this feature")]
        public void DuplicateLettersThatAreNotPermutations()
        {
            Assert.IsFalse(IsPermutation("gaame", "magge"));
            Assert.IsFalse(IsPermutation("magge", "gaame"));
        }

        [Test]
        [Ignore("Implement this feature")]
        public void SpacesWithUnequalNumberOfSpaces()
        {
            Assert.IsFalse(IsPermutation("mage ", "ga  me"));
            Assert.IsFalse(IsPermutation("ga  me", "mage "));
        }
    }
}
