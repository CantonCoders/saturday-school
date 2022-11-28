import unittest
from string_properties import is_unique


class IsUniqueTestCase(unittest.TestCase):
    def test_empty_string_is_unique(self):
        self.assertTrue(is_unique(""))

    @unittest.skip('Remove annotation to enable test')
    def test_single_character_is_unique(self):
        self.assertTrue(is_unique("A"))

    @unittest.skip('Remove annotation to enable test')
    def test_two_distinct_characters_is_unique(self):
        self.assertTrue(is_unique("AB"))

    @unittest.skip('Remove annotation to enable test')
    def test_two_identical_characters_is_not_unique(self):
        self.assertFalse(is_unique("AA"))

    @unittest.skip('Remove annotation to enable test')
    def test_same_character_upper_and_lower_is_unique(self):
        self.assertTrue(is_unique("Aa"))

    @unittest.skip('Remove annotation to enable test')
    def test_large_string_is_unique(self):
        self.assertTrue(is_unique("Math Problem"))

    @unittest.skip('Remove annotation to enable test')
    def test_large_string_is_not_unique(self):
        self.assertFalse(is_unique("Math Major"))


if __name__ == '__main__':
    unittest.main()
