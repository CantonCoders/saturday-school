import unittest
from string_properties import check_permutation


class CheckPermutationTestCase(unittest.TestCase):
    def test_equal_strings_are_permutations(self):
        self.assertTrue(check_permutation("dog", "dog"))

    @unittest.skip('Remove annotation to enable test')
    def test_strings_are_permutations(self):
        self.assertTrue(check_permutation("mage", "game"))

    @unittest.skip('Remove annotation to enable test')
    def test_strings_are_not_permutations(self):
        self.assertFalse(check_permutation("game", "games"))

    @unittest.skip('Remove annotation to enable test')
    def test_strings_with_equal_num_of_spaces_are_permutations(self):
        self.assertTrue(check_permutation(" mage", "ga me"))

    @unittest.skip('Remove annotation to enable test')
    def test_strings_with_unequal_num_of_spaces_are_not_permutations(self):
        self.assertFalse(check_permutation("mage ", "ga  me"))


if __name__ == '__main__':
    unittest.main()
