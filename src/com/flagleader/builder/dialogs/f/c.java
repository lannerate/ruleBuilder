package com.flagleader.builder.dialogs.f;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
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

public class c extends f
{
  private String a = null;
  private Text b;
  private Button c;
  private Button d;
  private Button e;
  private Button f;
  private Button g;
  private Button h;
  private Button i;
  private Button j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private ITreeNode s;
  private ArrayList t = new ArrayList();
  private Combo u;
  private ITreeNode v;

  public c(ITreeNode paramITreeNode)
  {
    super(new Shell());
    this.v = paramITreeNode;
  }

  public c(Shell paramShell)
  {
    super(paramShell);
  }

  private void a(IElement paramIElement, ArrayList paramArrayList)
  {
    if (((paramIElement instanceof IRuleTree)) || ((paramIElement instanceof IRulePackage)) || ((paramIElement instanceof IRuleGroup)))
    {
      paramArrayList.add(paramIElement.getDisplayName());
      this.t.add(0, paramIElement);
    }
    if (paramIElement.getParent() != null)
      if ((paramIElement.getParent() instanceof RuleRepository))
        this.t.add(0, paramIElement.getParent());
      else
        a(paramIElement.getParent(), paramArrayList);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    c("title.FindRuleDialog");
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
    this.u = c(localComposite2, 8, 230, 12);
    ArrayList localArrayList = new ArrayList();
    if (this.v != null)
      a(this.v, localArrayList);
    localArrayList.add(b("allrange.FindRuleDialog"));
    String[] arrayOfString = new String[localArrayList.size()];
    for (int i1 = 0; i1 < localArrayList.size(); i1++)
      arrayOfString[(localArrayList.size() - i1 - 1)] = localArrayList.get(i1).toString();
    this.u.setItems(arrayOfString);
    localComposite2 = a(localComposite1, 360, 80, 1);
    Group localGroup = new Group(localComposite2, 0);
    localGroup.setLayout(a(3));
    localGroup.setLayoutData(a(350, 60));
    localGroup.setText(ResourceTools.getMessage("context.FindRuleDialog"));
    this.e = new Button(localGroup, 16);
    this.e.setText(ResourceTools.getMessage("constant.FindRuleDialog"));
    this.e.setSelection(false);
    this.f = new Button(localGroup, 16);
    this.f.setText(ResourceTools.getMessage("variable.FindRuleDialog"));
    this.f.setSelection(false);
    this.i = new Button(localGroup, 16);
    this.i.setText(ResourceTools.getMessage("text.FindRuleDialog"));
    this.i.setSelection(false);
    this.h = new Button(localGroup, 16);
    this.h.setText(ResourceTools.getMessage("enum.FindRuleDialog"));
    this.h.setSelection(false);
    this.g = new Button(localGroup, 16);
    this.g.setText(ResourceTools.getMessage("display.FindRuleDialog"));
    this.g.setSelection(false);
    this.j = new Button(localGroup, 16);
    this.j.setText(ResourceTools.getMessage("java.FindRuleDialog"));
    this.j.setSelection(true);
    return localComposite1;
  }

  protected void okPressed()
  {
    this.a = this.b.getText();
    this.k = this.c.getSelection();
    this.l = this.d.getSelection();
    this.m = this.e.getSelection();
    this.n = this.f.getSelection();
    this.o = this.g.getSelection();
    this.p = this.h.getSelection();
    this.q = this.i.getSelection();
    this.r = this.j.getSelection();
    if (this.u.getSelectionIndex() > 0)
      this.s = ((ITreeNode)this.t.get(this.u.getSelectionIndex()));
    else
      this.s = ((ITreeNode)this.t.get(0));
    if (this.a.length() > 0)
      super.okPressed();
  }

  public String a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.k;
  }

  public boolean c()
  {
    return this.l;
  }

  public boolean d()
  {
    return this.m;
  }

  public boolean e()
  {
    return this.n;
  }

  public boolean f()
  {
    return this.o;
  }

  public boolean g()
  {
    return this.p;
  }

  public boolean h()
  {
    return this.q;
  }

  public boolean i()
  {
    return this.r;
  }

  public ITreeNode j()
  {
    return this.s;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.f.c
 * JD-Core Version:    0.6.0
 */