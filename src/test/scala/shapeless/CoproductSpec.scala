/*
 * Copyright 2016-2020 47 Degrees <https://47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package shapeless

import org.scalacheck.ScalacheckShapeless._
import org.scalaexercises.Test
import org.scalatest.refspec.RefSpec
import org.scalatestplus.scalacheck.Checkers
import shapelessex._

class CoproductSpec extends RefSpec with Checkers {
  def `selection op` = {
    check(
      Test.testSuccess(
        CoproductExercises.selection _,
        { None: Option[Int] } :: Option("foo") :: HNil
      )
    )
  }

  def `mapping op` = {
    check(
      Test.testSuccess(
        CoproductExercises.mapping _,
        Option(("foo", 3)) :: HNil
      )
    )
  }

  def `union op` = {
    check(
      Test.testSuccess(
        CoproductExercises.unionE _,
        { None: Option[Int] } :: Option("foo") :: { None: Option[Boolean] } :: HNil
      )
    )
  }

}
