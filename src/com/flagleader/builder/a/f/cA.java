package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.b.p;
import com.flagleader.repository.rlm.editen.IMultiLineEditen;
import com.flagleader.repository.rlm.lang.ILangToken;
import java.util.HashMap;
import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.J;
import org.agilemore.agilegrid.X;
import org.agilemore.agilegrid.e;

public class cA extends X
{
  public cA(ck paramck, e parame)
  {
    super(parame, true);
  }

  public J a(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((!ck.c(this.a)) && ((ck.g(this.a).get(new cs(paramInt1, paramInt2)) instanceof ILangToken)))
    {
      p localp = new p(ck.b(this.a).getShell(), ck.b(this.a), (IMultiLineEditen)ck.g(this.a).get(new cs(paramInt1, paramInt2)));
      if (localp.open() == 0)
        this.a.update();
    }
    return null;
  }

  public void a(J paramJ, G paramG)
  {
    paramJ.c(ck.g(this.a).get(new cs(paramG.c, paramG.d)));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cA
 * JD-Core Version:    0.6.0
 */