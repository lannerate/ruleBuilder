package com.flagleader.repository.rlm;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.editen.IStaticEditen;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.StringTokenizer;

public class ElementTextToken extends AbstractRuleObject
  implements IStaticEditen
{
  private int size = 0;
  private int pos = 0;
  private String elementUuid = "";
  private String uniqueName = "";
  private String colorType = "default";

  public ElementTextToken()
  {
  }

  public ElementTextToken(int paramInt)
  {
    this.size = paramInt;
  }

  public ElementTextToken(ElementTextToken paramElementTextToken)
  {
    super(paramElementTextToken);
    this.size = paramElementTextToken.size;
  }

  public ElementTextToken(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    setDisplayName(paramString1);
    this.colorType = paramString2;
    this.pos = paramInt;
    this.elementUuid = paramString3;
    this.uniqueName = paramString4;
  }

  public String getDisplayName()
  {
    if (getMemberElement() != null)
    {
      String str1 = getMemberElement().getDisplayName();
      int i = str1.indexOf("{");
      int j = 0;
      StringTokenizer localStringTokenizer = new StringTokenizer(str1.substring(str1.indexOf("{") + 1), "{");
      while (localStringTokenizer.hasMoreTokens())
      {
        String str2 = localStringTokenizer.nextToken().trim();
        if (str2.indexOf("}") >= 0)
        {
          String str3 = str2.substring(0, str2.indexOf("}"));
          if (this.pos != j++)
            continue;
          setDisplayName(str2.substring(str2.indexOf("}") + 1));
          break;
        }
        if (this.pos != j++)
          continue;
        setDisplayName(str2);
        break;
      }
    }
    return super.getDisplayName();
  }

  public IElement getMemberElement()
  {
    IElement localIElement = null;
    if ((this.elementUuid.length() > 0) || (this.uniqueName.length() > 0))
      localIElement = d();
    if (localIElement != null)
    {
      if (!localIElement.getUuid().equals(this.elementUuid))
      {
        this.elementUuid = localIElement.getUuid();
        if (getRoot() != null)
          getRoot().setNeedSave();
      }
      if ((localIElement instanceof IBusinessObject))
        this.uniqueName = ((IBusinessObject)localIElement).getUniqueName();
    }
    return localIElement;
  }

  protected IElement d()
  {
    IBusinessObject localIBusinessObject = null;
    Envionment localEnvionment = getEnvionment();
    if (localEnvionment != null)
      localIBusinessObject = localEnvionment.getBusinessObject(this.elementUuid, this.uniqueName);
    return localIBusinessObject;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitElementTextToken(this);
  }

  public IElement deepClone()
  {
    return new ElementTextToken(this);
  }

  public String getName()
  {
    return "ElementTextToken";
  }

  public int getSize()
  {
    return this.size;
  }

  public void setSize(int paramInt)
  {
    this.size = paramInt;
  }

  public String getColorType()
  {
    return this.colorType;
  }

  public void setColorType(String paramString)
  {
    this.colorType = paramString;
  }

  public String getElementUuid()
  {
    return this.elementUuid;
  }

  public void setElementUuid(String paramString)
  {
    this.elementUuid = paramString;
  }

  public int getPos()
  {
    return this.pos;
  }

  public void setPos(int paramInt)
  {
    this.pos = paramInt;
  }

  public String getUniqueName()
  {
    return this.uniqueName;
  }

  public void setUniqueName(String paramString)
  {
    this.uniqueName = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.ElementTextToken
 * JD-Core Version:    0.6.0
 */