package org.example.leetcode.recursion;

import org.assertj.core.api.Assertions;
import org.example.leetcode.utils.TreeNode;
import org.example.leetcode.utils.TreeNodeFactory;
import org.example.leetcode.utils.TreeNodeUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

class AllPossibleFullBinaryTreesTest {

    private AllPossibleFullBinaryTrees obj = new AllPossibleFullBinaryTrees();

    @Test
    void allPossibleFBT() {
        List<TreeNode> expectedFBTList = List.of(
                TreeNodeFactory.create("[0,0,0,null,null,0,0,null,null,0,0]"),
                TreeNodeFactory.create("[0,0,0,null,null,0,0,0,0]"),
                TreeNodeFactory.create("[0,0,0,0,0,0,0]"),
                TreeNodeFactory.create("[0,0,0,0,0,null,null,null,null,0,0]"),
                TreeNodeFactory.create("[0,0,0,0,0,null,null,0,0]")
        );
        List<TreeNode> actualFBTList = obj.allPossibleFBT(7);
//        Assertions.assertThat(actualFBTList).hasSameElementsAs(expectedFBTList);
        Assertions.assertThat(actualFBTList.stream().allMatch(actualFBT ->
                expectedFBTList.stream().anyMatch(expectedFBT -> TreeNodeUtils.isSameTree(expectedFBT, actualFBT))
        )).isTrue();
        Assertions.assertThat(actualFBTList.size()).isEqualTo(expectedFBTList.size());

//        System.out.println(obj.allPossibleFBT(33).size());
    }

    @Test
    void allPossibleFBT1() {
        List<TreeNode> tnList = List.of(
                TreeNodeFactory.create("[0,0,0]")
        );
        Assertions.assertThat(tnList).hasSameElementsAs(obj.allPossibleFBT(3));
    }

    @Test
    void allPossibleFBT2() {
//        List<TreeNode> tnList = List.of(
//                TreeNodeFactory.create("[0,0,0,null,null,0,0,null,null,0,0]"),
//                TreeNodeFactory.create("[0,0,0,null,null,0,0,0,0]"),
//                TreeNodeFactory.create("[0,0,0,0,0,0,0]"),
//                TreeNodeFactory.create("[0,0,0,0,0,null,null,null,null,0,0]"),
//                TreeNodeFactory.create("[0,0,0,0,0,null,null,0,0]")
//        );
//        List<TreeNode> tnList1 = List.of(
//                [0,0,0,0,0,null,null,0,0],
//        [0,0,0,0,0,null,null,null,null,0,0],
//        [0,0,0,0,0,0,0],
//        [0,0,0,0,0,0,0],
//        [0,0,0,null,null,0,0,0,0],
//        [0,0,0,null,null,0,0,null,null,0,0]
//                TreeNodeFactory.create("[0,0,0,null,null,0,0,null,null,0,0]"),
//                TreeNodeFactory.create("[0,0,0,null,null,0,0,0,0]"),
//                TreeNodeFactory.create("[0,0,0,0,0,0,0]"),
//                TreeNodeFactory.create("[0,0,0,0,0,null,null,null,null,0,0]"),
//                TreeNodeFactory.create("[0,0,0,0,0,null,null,0,0]")
//        );
//        Assertions.assertThat(tnList).hasSameElementsAs(obj.allPossibleFBT(7));
    }
}