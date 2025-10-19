package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `커스텀 구분자 사용`() {
        assertSimpleTest {
            run("//;\\n1")
            assertThat(output()).contains("결과 : 1")
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `쉼표_구분자_테스트`() {
        assertSimpleTest {
            run("1,2,3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `쉼표와_콜론_구분자_테스트`() {
        assertSimpleTest {
            run("1,2:3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `복합_커스텀_구분자_테스트`() {
        assertSimpleTest {
            run("//;\\n1,2;3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `빈_문자열_테스트`() {
        assertSimpleTest {
            run(" ")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    fun `숫자_아닌_값_예외_테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,a,2") }
        }
    }

    override fun runMain() {
        main()
    }
}
