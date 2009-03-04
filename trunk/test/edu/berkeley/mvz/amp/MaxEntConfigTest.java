/*
 * Copyright 2009 University of California at Berkeley
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package edu.berkeley.mvz.amp;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;

import edu.berkeley.mvz.amp.MaxEntConfig.Builder;
import edu.berkeley.mvz.amp.MaxEntConfig.CommandLineOption;

public class MaxEntConfigTest {

  private static Logger log = Logger.getLogger(MaxEntConfigTest.class);

  @Test
  public void addOptions() {
    Builder b = new Builder(".");
    b.addOption(CommandLineOption.RANDOM_SEED, "20");
    b.addOption(CommandLineOption.JACK_KNIFE);
    Assert
        .assertEquals(b.getOptions().get(CommandLineOption.RANDOM_SEED), "20");
    log.info(b.toString());

    b = new Builder(".");
    try {
      b.addOption(null);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      log.info(e);
    }

    b = new Builder(".");
    try {
      b.addOption(null, "");
      Assert.fail();
    } catch (IllegalArgumentException e) {
      log.info(e);
    }

    b = new Builder(".");
    try {
      b.addOption(null, null);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      log.info(e);
    }

    b = new Builder(".");
    try {
      b.addOption(CommandLineOption.JACK_KNIFE, null);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      log.info(e);
    }
  }

  @Test
  public void builderConstructor() {
    Builder b;
    try {
      b = new Builder("BOGUS PATH");
      Assert.fail();
    } catch (IllegalArgumentException e) {
    }

    b = new Builder(".");
    Assert.assertNotNull(b);
  }
}
