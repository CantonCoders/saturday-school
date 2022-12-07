using Newtonsoft.Json.Linq;
using NUnit.Framework;
using StringHomework;
using System;
using System.Collections.Generic;
using System.Text;

namespace StringHomeworkTest
{
    internal class URLifyTest
    {


        [Test]        
        public void ContainsNoSpaces()
        {
            TestReplaceSpaces("Coding", "Coding");
        }

        [Test]
        public void ContainsSingleSpaceContainsNoSpaces()
        {
            TestReplaceSpaces("Canton Coders ", "Canton%20Coders");
        }

        [Test]
        public void ContainsMultipleSpaces()
        {
            TestReplaceSpaces("Coding with Canton Coders", "Coding%20with%20Canton%20Coders");
        }

        private static void TestReplaceSpaces(String input, String output)
        {
            var inputArray = new char[output.Length];
            Array.Copy(sourceArray: input.ToCharArray(),
                       inputArray,
                       output.Length);

            URLify.ReplaceSpaces(inputArray);
            Assert.AreEqual(inputArray, output.ToCharArray());
        }

    }
}
