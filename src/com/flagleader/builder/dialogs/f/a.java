package com.flagleader.builder.dialogs.f;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleRepository;
import java.util.ArrayList;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class a extends f
{
  private String a = null;
  private Text b;
  private Button c;
  private Button d;
  private Button e;
  private Button f;
  private Button g;
  private Button h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private ITreeNode o;
  private ArrayList p = new ArrayList();
  private Combo q;
  private ITreeNode r;

  public a(ITreeNode paramITreeNode)
  {
    super(new Shell());
    this.r = paramITreeNode;
  }

  public a(Shell paramShell)
  {
    super(paramShell);
  }

  private void a(IElement paramIElement, ArrayList paramArrayList)
  {
    if ((paramIElement instanceof IRuleTree))
    {
      paramArrayList.add(paramIElement.getDisplayName());
      this.p.add(0, paramIElement);
    }
    if (paramIElement.getParent() != null)
      if ((paramIElement.getParent() instanceof RuleRepository))
        this.p.add(0, paramIElement.getParent());
      else
        a(paramIElement.getParent(), paramArrayList);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    c("title.FindNodeDialog");
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = a(localComposite1, 360, 80, 2);
    a(localComposite2, "value.FindRuleDialog");
    this.b = b(localComposite2, 2048, 250, 12);
    this.c = new Button(localComposite2, 32);
    this.c.setText(ResourceTools.getMessage("match_case.FindRuleDialog"));
    this.d = new Button(localComposite2, 32);
    this.d.setText(ResourceTools.getMessage("match_word.FindRuleDialog"));
    if (this.a != null)
    {
      this.b.setText(this.a);
      this.b.selectAll();
    }
    a(localComposite2, "range.FindRuleDialog");
    this.q = c(localComposite2, 8, 230, 12);
    ArrayList localArrayList = new ArrayList();
    if (this.r != null)
      a(this.r, localArrayList);
    localArrayList.add(b("allrange.FindRuleDialog"));
    String[] arrayOfString = new String[localArrayList.size()];
    for (int i1 = 0; i1 < localArrayList.size(); i1++)
      arrayOfString[(localArrayList.size() - i1 - 1)] = localArrayList.get(i1).toString();
    this.q.setItems(arrayOfString);
    localComposite2 = a(localComposite1, 360, 80, 1);
    Group localGroup = new Group(localComposite2, 0);
    localGroup.setLayout(a(2));
    localGroup.setLayoutData(a(350, 60));
    localGroup.setText(ResourceTools.getMessage("context.FindRuleDialog"));
    this.e = new Button(localGroup, 16);
    this.e.setText(ResourceTools.getMessage("rulepackages.FindRuleDialog"));
    this.e.setSelection(true);
    this.g = new Button(localGroup, 16);
    this.g.setText(ResourceTools.getMessage("rules.FindRuleDialog"));
    this.g.setSelection(false);
    this.f = new Button(localGroup, 16);
    this.f.setText(ResourceTools.getMessage("envionment.FindRuleDialog"));
    this.f.setSelection(false);
    this.h = new Button(localGroup, 16);
    this.h.setText(ResourceTools.getMessage("class.FindRuleDialog"));
    this.h.setSelection(false);
    return localComposite1;
  }

  protected void okPressed()
  {
    this.a = this.b.getText();
    this.i = this.c.getSelection();
    this.j = this.d.getSelection();
    this.k = this.e.getSelection();
    this.l = this.f.getSelection();
    this.m = this.g.getSelection();
    this.n = this.h.getSelection();
    if (this.q.getSelectionIndex() > 0)
      this.o = ((ITreeNode)this.p.get(this.q.getSelectionIndex()));
    else
      this.o = ((ITreeNode)this.p.get(0));
    if (this.a.length() > 0)
      super.okPressed();
  }

  public String a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.i;
  }

  public boolean c()
  {
    return this.j;
  }

  public boolean d()
  {
    return this.k;
  }

  public boolean e()
  {
    return this.l;
  }

  public boolean f()
  {
    return this.m;
  }

  public boolean g()
  {
    return this.n;
  }

  public ITreeNode h()
  {
    return this.o;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.f.a
 * JD-Core Version:    0.6.0
 */