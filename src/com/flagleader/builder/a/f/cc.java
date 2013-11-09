package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.b.p;
import com.flagleader.repository.rlm.editen.IMultiLineEditen;
import java.util.HashMap;
import org.agilemore.agilegrid.J;
import org.agilemore.agilegrid.X;
import org.agilemore.agilegrid.e;

public class cc extends X
{
  public cc(bQ parambQ, e parame)
  {
    super(parame, true);
  }

  public J a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (!bQ.a(this.a))
    {
      Object localObject = bQ.h(this.a).get(new bY(paramInt1, paramInt2));
      if ((localObject instanceof IMultiLineEditen))
      {
        p localp = new p(bQ.i(this.a).getShell(), bQ.i(this.a), (IMultiLineEditen)localObject);
        if (localp.open() == 0)
          this.a.update();
      }
    }
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cc
 * JD-Core Version:    0.6.0
 */