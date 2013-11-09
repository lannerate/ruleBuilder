package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.d;
import com.flagleader.repository.IElement;
import com.flagleader.repository.export.PageFieldModel;

public class aj
  implements d
{
  private String b;
  private PageFieldModel c;
  private boolean d;

  public aj(W paramW, String paramString, PageFieldModel paramPageFieldModel, boolean paramBoolean)
  {
    this.b = paramString;
    this.c = paramPageFieldModel;
    this.d = paramBoolean;
  }

  public String[] a()
  {
    return W.a(this.a, this.c, this.b);
  }

  public boolean a(int paramInt)
  {
    String[] arrayOfString = W.b(this.a, this.c, this.b);
    if (this.d)
    {
      IElement[] arrayOfIElement = this.a.g();
      for (int i = 0; i < arrayOfIElement.length; i++)
      {
        if (!(arrayOfIElement[i] instanceof PageFieldModel))
          continue;
        W.a(this.a, (PageFieldModel)arrayOfIElement[i], arrayOfString[paramInt], this.b);
      }
      this.a.update();
      return false;
    }
    W.a(this.a, this.c, arrayOfString[paramInt], this.b);
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.aj
 * JD-Core Version:    0.6.0
 */