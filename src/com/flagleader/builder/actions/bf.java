package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.widget.a.q;
import java.util.HashMap;

public class bf
{
  private HashMap a;
  private BuilderManager b;

  public bf(BuilderManager paramBuilderManager)
  {
    this.b = paramBuilderManager;
    this.a = new HashMap();
    b();
  }

  private void b()
  {
    this.a.put(new String("error"), new bh(this));
    this.a.put(new String("Refresh"), new bj(this));
  }

  public bi a(String paramString)
  {
    Object localObject = null;
    if (this.a != null)
    {
      if (this.a.containsKey(paramString))
      {
        localObject = (bi)this.a.get(paramString);
      }
      else
      {
        ak localak = this.b.getTreeNodeAction(paramString);
        if (localak != null)
        {
          localObject = new bk(this, localak);
          this.a.put(paramString, localObject);
        }
        else
        {
          localObject = new bh(this);
        }
      }
    }
    else
      localObject = new bh(this);
    return (bi)localObject;
  }

  public q a()
  {
    return this.b.getMenuAndToolBar().i();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bf
 * JD-Core Version:    0.6.0
 */