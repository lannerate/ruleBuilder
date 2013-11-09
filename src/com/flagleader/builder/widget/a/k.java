package com.flagleader.builder.widget.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.C;
import com.flagleader.repository.export.RspTags;
import com.flagleader.repository.export.Tag;
import com.flagleader.repository.export.TagType;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class k extends af
{
  private C f;
  private RspTags g = RspTags.getInstance();

  public k(Composite paramComposite, int paramInt, RspTags paramRspTags)
  {
    super(paramComposite, paramInt);
    this.g = paramRspTags;
  }

  public k(Composite paramComposite, int paramInt)
  {
    super(paramComposite, paramInt);
  }

  public k(BuilderManager paramBuilderManager, Composite paramComposite, int paramInt)
  {
    super(paramBuilderManager, paramComposite, paramInt);
  }

  protected Menu i()
  {
    StyledText localStyledText = m();
    Menu localMenu1 = n();
    MenuItem localMenuItem1 = new MenuItem(localMenu1, 8);
    localMenuItem1.setText(ResourceTools.getMessage("selectall.popup"));
    localMenuItem1.addSelectionListener(new l(this, localStyledText));
    localMenuItem1.setAccelerator(SWT.MOD1 + 65);
    if (localStyledText.getSelectionText().length() > 0)
    {
      localMenuItem1 = new MenuItem(localMenu1, 8);
      localMenuItem1.setText(ResourceTools.getMessage("cut.popup"));
      localMenuItem1.setAccelerator(SWT.MOD1 + 88);
      localMenuItem1.addSelectionListener(new m(this, localStyledText));
      localMenuItem1 = new MenuItem(localMenu1, 8);
      localMenuItem1.setText(ResourceTools.getMessage("copy.popup"));
      localMenuItem1.addSelectionListener(new n(this, localStyledText));
      localMenuItem1.setAccelerator(SWT.MOD1 + 67);
    }
    localMenuItem1 = new MenuItem(localMenu1, 8);
    localMenuItem1.setText(ResourceTools.getMessage("paste.popup"));
    localMenuItem1.addSelectionListener(new o(this, localStyledText));
    localMenuItem1.setAccelerator(SWT.MOD1 + 86);
    new MenuItem(localMenu1, 2);
    if ((localStyledText.getSelectionText().length() == 0) && (j() != null))
    {
      List localList1 = j().getTagTypes();
      for (int i = 0; i < localList1.size(); i++)
      {
        TagType localTagType = (TagType)localList1.get(i);
        localMenuItem1 = new MenuItem(localMenu1, 64);
        Menu localMenu2 = new Menu(localMenuItem1);
        localMenuItem1.setMenu(localMenu2);
        localMenuItem1.setText(localTagType.getDisName());
        List localList2 = localTagType.getTags();
        for (int j = 0; j < localList2.size(); j++)
        {
          Tag localTag = (Tag)localList2.get(j);
          MenuItem localMenuItem2 = new MenuItem(localMenu2, 8);
          localMenuItem2.setText(localTag.getDisName());
          String str = localTagType.getName() + "." + localTag.getName();
          localMenuItem2.addSelectionListener(new p(this, localTag, localStyledText, str));
        }
      }
    }
    localMenu1.setVisible(true);
    return localMenu1;
  }

  protected StyledText a(Composite paramComposite, int paramInt)
  {
    StyledText localStyledText = super.a(paramComposite, paramInt);
    this.f = new C();
    localStyledText.addLineStyleListener(this.f);
    return localStyledText;
  }

  public RspTags j()
  {
    return this.g;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.k
 * JD-Core Version:    0.6.0
 */