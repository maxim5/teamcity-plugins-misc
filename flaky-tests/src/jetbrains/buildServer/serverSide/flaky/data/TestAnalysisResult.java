/*
 * Copyright (c) 2000-2012 by JetBrains s.r.o. All Rights Reserved.
 * Use is subject to license terms.
 */
package jetbrains.buildServer.serverSide.flaky.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Maxim Podkolzine (maxim.podkolzine@jetbrains.com)
 * @since 8.0
 */
public class TestAnalysisResult implements Serializable {
  public static final TestAnalysisResult EMPTY_FLAKY_TESTS = new TestAnalysisResult();

  private List<TestData> myFlakyTests = Collections.emptyList();
  private List<TestData> myAlwaysFailingTests = Collections.emptyList();

  private Date myStartDate = null;
  private Date myFinishDate = null;
  private int myTotalTests = 0;

  public TestAnalysisResult() {
  }

  @NotNull
  public List<TestData> getFlakyTests() {
    return myFlakyTests;
  }

  @NotNull
  public List<TestData> getAlwaysFailingTests() {
    return myAlwaysFailingTests;
  }

  @Nullable
  public Date getStartDate() {
    return myStartDate;
  }

  @Nullable
  public Date getFinishDate() {
    return myFinishDate;
  }

  public int getTotalTests() {
    return myTotalTests;
  }

  public void setTests(@NotNull List<TestData> allTests) {
    myFlakyTests = new ArrayList<TestData>();
    myAlwaysFailingTests = new ArrayList<TestData>();
    for (TestData test : allTests) {
      if (test.isAlwaysFailing()) {
        myAlwaysFailingTests.add(test);
      } else {
        myFlakyTests.add(test);
      }
    }
  }

  public void setStartDate(@NotNull Date startDate) {
    myStartDate = startDate;
  }

  public void setFinishDate(@NotNull Date finishDate) {
    myFinishDate = finishDate;
  }

  public void setTotalTests(int totalTests) {
    myTotalTests = totalTests;
  }
}
