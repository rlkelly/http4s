package org.http4s
package headers

import org.http4s.parser.HttpHeaderParser
import org.http4s.util.Writer
import org.http4s.{Header, HeaderKey, ParseResult}

object `X-B3-SpanId` extends HeaderKey.Internal[`X-B3-SpanId`] with HeaderKey.Singleton {
  override def parse(s: String): ParseResult[`X-B3-SpanId`] =
    HttpHeaderParser.X_B3_SPANID(s)

}

final case class `X-B3-SpanId`(traceId: Long) extends Header.Parsed {
  override def key: `X-B3-SpanId`.type = `X-B3-SpanId`

  override def renderValue(writer: Writer): writer.type = writer.append(value)
}
